package com.example.lib.Model;

import java.util.List;

public class FavoriteModel
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
        private String word2;

        private String id;

        private String word;

        public String getWord2 ()
        {
            return word2;
        }

        public void setWord2 (String word2)
        {
            this.word2 = word2;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getWord ()
        {
            return word;
        }

        public void setWord (String word)
        {
            this.word = word;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [word2 = "+word2+", id = "+id+", word = "+word+"]";
        }
    }
}
