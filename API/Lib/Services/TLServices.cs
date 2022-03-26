using Lib.Entity;
using Lib.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Services
{
    public class TLServices
    {
        private ITLRepository tLRepository { get; set; }
        private ApplicationDbContext dbContext;
        public TLServices(ApplicationDbContext dbContext, ITLRepository tLRepository)
        {
            this.tLRepository = tLRepository;
            this.dbContext = dbContext;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<TestListening> GetTL()
        {
            return tLRepository.GetTL();
        }
    }
}
