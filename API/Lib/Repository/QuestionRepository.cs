using Lib.Data;
using Lib.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Repository
{
    public interface IQuestionRepository: IRepository<Question> { List<Question> GetQuestions(); }
    public class QuestionRepository : RepositoryBase<Question>, IQuestionRepository
    {
        public QuestionRepository(ApplicationDbContext dbContext): base(dbContext) { }

        public List<Question> GetQuestions()
        {
            var query = _dbcontext.Question;
            return query.ToList();
        }
    }
}
