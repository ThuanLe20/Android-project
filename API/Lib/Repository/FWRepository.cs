using Lib.Data;
using Lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Repository
{
    public interface IFWRepository : IRepository<FavoriteWord> { List<FavoriteWord> GetFW(); }
    public class FWRepository : RepositoryBase<FavoriteWord>, IFWRepository
    {
        public FWRepository(ApplicationDbContext dbContext) : base(dbContext) { }

        public List<FavoriteWord> GetFW()
        {
            var query = _dbcontext.FavoriteWord;
            return query.ToList();
        }
    }
}
