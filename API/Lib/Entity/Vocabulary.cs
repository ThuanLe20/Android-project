using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lib.Entity
{
    public class Vocabulary
    {
        [Key]
        public Guid Id { get; set; }
        public string English { get; set; }
        public string Vietnamese { get; set; }
    }
}
