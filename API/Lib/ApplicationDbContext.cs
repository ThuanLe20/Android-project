
using Lib.Entity;
using Lib.Security;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib
{
    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {
        public DbSet<Question> Question { get; set; }
        public DbSet<Word> Word { get; set; }

        public DbSet<FavoriteWord> FavoriteWord { get; set; }
        public DbSet<TestListening> TestListening { get; set; }

        public DbSet<Mutichoice> Mutichoices { get; set; }
        public DbSet<Vocabulary> Vocabulary { get; set; }
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options): base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
        }
    }
}
