using Lib.Entity;
using Lib.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Services
{
    public class WordServices
    {
        private IWordRepository wordRepository { get; set; }
        private ApplicationDbContext dbContext;
        public WordServices(ApplicationDbContext dbContext, IWordRepository wordRepository)
        {
            this.wordRepository = wordRepository;
            this.dbContext = dbContext;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<Word> GetWord()
        {
            return wordRepository.GetWord();
        }
    }
}
