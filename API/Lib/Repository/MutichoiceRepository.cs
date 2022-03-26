using Lib.Entity;
using Lib.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Reponsitories
{
    public interface IMutichoiceRepository : IRepository<Mutichoice> {
        List<Mutichoice> ListMuitichoice();
    }
    public class MutichoiceRepository : RepositoryBase<Mutichoice>, IMutichoiceRepository
    {
        public MutichoiceRepository(ApplicationDbContext dbContext) : base(dbContext) { }

        public List<Vocabulary> GetListVocabulary()
        {
            var query = _dbcontext.Vocabulary;
            return query.ToList();
        }
        public List<Mutichoice> ListMuitichoice()
        {
            List<Vocabulary> list = GetListVocabulary();
            List<Mutichoice> tracNghiem = new List<Mutichoice>();
            
            foreach (var item in list)
            {
                Mutichoice addItem = new Mutichoice();
                addItem.Question = item.English;
                addItem.Correct = item.Vietnamese;

                var rand = new Random();
                var listIncorrect = list.Where(x => x.Vietnamese != item.Vietnamese).ToList();
                //Lựa chọn ngẫu nhiên câu lựa chọn
                List<String> incorrect1 = listIncorrect.OrderBy(c => rand.Next()).Select(c => c.Vietnamese).Take(3).ToList();
                //Thêm câu đúng vào list
                incorrect1.Add(item.Vietnamese);
                //Tiến hành Xáo trộn

                List<String> xaotron = incorrect1.OrderBy(item => rand.Next()).ToList();
                addItem.Choice1 = xaotron[0];
                addItem.Choice2 = xaotron[1];
                addItem.Choice3 = xaotron[2];
                addItem.Choice4 = xaotron[3];
                tracNghiem.Add(addItem);
            }
            // Tiến hành xáo trộn câu hỏi
            var ran = new Random();
            var xaoTronCauHoi = tracNghiem.OrderBy(item => ran.Next()).ToList();
            return xaoTronCauHoi;
        }


    }
}
