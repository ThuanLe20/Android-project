using Lib.Entity;
using Lib.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Services
{
    public class FWServices
    {
        private IFWRepository FWRepository { get; set; }
        private ApplicationDbContext dbContext;
        public FWServices(ApplicationDbContext dbContext, IFWRepository FWRepository)
        {
            this.FWRepository = FWRepository;
            this.dbContext = dbContext;
        }
        public void Save()
        {
            dbContext.SaveChanges();
        }
        public List<FavoriteWord> GetFW()
        {
            return FWRepository.GetFW();
        }
        public void InsertFW(FavoriteWord favoriteWord)
        {
            Console.WriteLine(favoriteWord.Id.ToString());
            if (favoriteWord.Id.ToString() == "00000000-0000-0000-0000-000000000000")
            {
                dbContext.FavoriteWord.Add(favoriteWord);
            }
            else
            {
                FavoriteWord favoriteWordUp = dbContext.FavoriteWord.Find(favoriteWord.Id);
                favoriteWordUp.word = favoriteWord.word;
                favoriteWordUp.word2 = favoriteWord.word2;
            }
            
            Save();
        }
        public void DeleteFW(FavoriteWord favoriteWord)
        {
            FavoriteWord favoriteWordUp = dbContext.FavoriteWord.Find(favoriteWord.Id);
            dbContext.FavoriteWord.Remove(favoriteWordUp);
            Save(); 
        }
    }
}
