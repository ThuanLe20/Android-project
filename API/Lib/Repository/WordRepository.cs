using Lib.Data;
using Lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Repository
{
    public interface IWordRepository : IRepository<Word> { List<Word> GetWord(); }
    public class WordRepository : RepositoryBase<Word>, IWordRepository
    {
        public WordRepository(ApplicationDbContext dbContext) : base(dbContext) { }

        public List<Word> GetWord()
        {
            var query = _dbcontext.Word;
            return query.ToList();
        }
    }
}
