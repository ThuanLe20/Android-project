package com.example.lib.Model;

import java.util.List;

public class WordModel
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
        private String nameword;

        private String kn;

        private String pd;

        private String nv;

        private String kd;

        private String description;

        private String id;

        private String signal;

        public String getNameword ()
        {
            return nameword;
        }

        public void setNameword (String nameword)
        {
            this.nameword = nameword;
        }

        public String getKn ()
        {
            return kn;
        }

        public void setKn (String kn)
        {
            this.kn = kn;
        }

        public String getPd ()
        {
            return pd;
        }

        public void setPd (String pd)
        {
            this.pd = pd;
        }

        public String getNv ()
        {
            return nv;
        }

        public void setNv (String nv)
        {
            this.nv = nv;
        }

        public String getKd ()
        {
            return kd;
        }

        public void setKd (String kd)
        {
            this.kd = kd;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getSignal ()
        {
            return signal;
        }

        public void setSignal (String signal)
        {
            this.signal = signal;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [nameword = "+nameword+", kn = "+kn+", pd = "+pd+", nv = "+nv+", kd = "+kd+", description = "+description+", id = "+id+", signal = "+signal+"]";
        }
    }
}
