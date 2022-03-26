using Lib.Data;
using Lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Repository
{
    public interface ITLRepository : IRepository<TestListening> { List<TestListening> GetTL(); }
    public class TLRepository : RepositoryBase<TestListening>, ITLRepository
    {
        public TLRepository(ApplicationDbContext dbContext) : base(dbContext) { }

        public List<TestListening> GetTL()
        {
            var query = _dbcontext.TestListening;
            return query.ToList();
        }
    }
}
