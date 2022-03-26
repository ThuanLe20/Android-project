package com.example.lib.Model;

import java.util.List;

public class MutichoiceModel
{
    private List<Data> data;

    private String status;

    public List<Data> getData ()
    {
        return data;
    }

    public void setData (List<Data> data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
    public class Data
    {
        private String question;

        private String correct;

        private String id;

        private String choice3;

        private String choice4;

        private String choice1;

        private String choice2;

        public String getQuestion ()
        {
            return question;
        }

        public void setQuestion (String question)
        {
            this.question = question;
        }

        public String getCorrect ()
        {
            return correct;
        }

        public void setCorrect (String correct)
        {
            this.correct = correct;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getChoice3 ()
        {
            return choice3;
        }

        public void setChoice3 (String choice3)
        {
            this.choice3 = choice3;
        }

        public String getChoice4 ()
        {
            return choice4;
        }

        public void setChoice4 (String choice4)
        {
            this.choice4 = choice4;
        }

        public String getChoice1 ()
        {
            return choice1;
        }

        public void setChoice1 (String choice1)
        {
            this.choice1 = choice1;
        }

        public String getChoice2 ()
        {
            return choice2;
        }

        public void setChoice2 (String choice2)
        {
            this.choice2 = choice2;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [question = "+question+", correct = "+correct+", id = "+id+", choice3 = "+choice3+", choice4 = "+choice4+", choice1 = "+choice1+", choice2 = "+choice2+"]";
        }
    }
}
