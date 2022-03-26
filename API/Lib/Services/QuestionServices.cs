using Lib.Entity;
using Lib.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Services
{
    public class QuestionServices
    {
        private IQuestionRepository questionRepository { get; set; }
        private ApplicationDbContext dbContext;
        public QuestionServices(ApplicationDbContext dbContext, IQuestionRepository questionRepository)
        {
            this.questionRepository = questionRepository;
            this.dbContext = dbContext;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<Question> GetquestionList()
        {
            return questionRepository.GetQuestions();
        }
    }
}
