using DAMB.Models;
using Lib.Entity;
using Lib.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Testing.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class TestController : ControllerBase
    {
        private QuestionServices questionServices { get; set; }
        private WordServices wordServices { get; set; }

        private FWServices fWServices { get; set; }
        private TLServices tLServices { get; set; }

        private MutichoiceServices mutichoiceService { get; set; }
        public TestController(QuestionServices questionServices, WordServices wordServices, FWServices fWServices, TLServices tLServices, MutichoiceServices mutichoiceService)
        {
            this.questionServices = questionServices;
            this.wordServices = wordServices;
            this.fWServices = fWServices;
            this.tLServices = tLServices;
            this.mutichoiceService = mutichoiceService;
        }
        [HttpGet("get-question-list")]
        public ActionResult GetquestionList()
        {
            return Ok(new { status = true, data = questionServices.GetquestionList() });
        }
        [HttpGet("get-word-list")]
        public ActionResult GetWord()
        {
            return Ok(new { status = true, data = wordServices.GetWord() });
        }
        [HttpGet("get-fw-list")]
        public ActionResult GetFW()
        {
            return Ok(new { status = true, data = fWServices.GetFW() });
        }
        [HttpGet("get-tl-list")]
        public ActionResult GetTL()
        {
            return Ok(new { status = true, data = tLServices.GetTL() });
        }
        [HttpPost("insert-fw-list")]
        public ActionResult InsertFW(InsertFWModel insertFWModel)
        {
            FavoriteWord fw = new FavoriteWord();
            fw.Id = insertFWModel.Id;
            fw.word = insertFWModel.word;
            fw.word2 = insertFWModel.word2;
            fWServices.InsertFW(fw);
            return Ok(new { status = true, message = "" });
        }
        [HttpPost("delete-fw-list")]
        public ActionResult DeleteFW2(InsertFWModel insertFWModel)
        {
            FavoriteWord fw = new FavoriteWord();
            fw.Id = insertFWModel.Id;
            fw.word = insertFWModel.word;
            fw.word2 = insertFWModel.word2;
            fWServices.DeleteFW(fw);
            return Ok(new { status = true, message = "" });
        }
        [HttpGet("get-mutichoice-list")]
        public ActionResult GetMutichoiceList()
        {
            return Ok(new { status = true, data = mutichoiceService.GetMutichoicesList() });
        }
    }
}
