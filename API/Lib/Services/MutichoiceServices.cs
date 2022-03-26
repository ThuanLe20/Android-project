using Lib.Entity;
using Lib.Reponsitories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Services
{
    public class MutichoiceServices
    {
        private IMutichoiceRepository mutichoiceRepository { get; set; }
        private ApplicationDbContext dbContext;
        public MutichoiceServices(ApplicationDbContext dbContext, IMutichoiceRepository mutichoiceRepository) {
            this.mutichoiceRepository = mutichoiceRepository;
            this.dbContext = dbContext;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<Mutichoice> GetMutichoicesList()
        {
            return mutichoiceRepository.ListMuitichoice();
        }
    }
}
