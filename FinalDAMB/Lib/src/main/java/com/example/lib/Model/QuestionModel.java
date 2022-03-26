package com.example.lib.Model;

import java.util.List;

public class QuestionModel
{
    private List<Data> data;

    private String status;

    public QuestionModel(String cauhoi, String a, String b, String c, String d, String dapan, String s) {
    }

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
        private String a;

        private String b;

        private String c;

        private String d;

        private String cauhoi;

        private String idcate;

        private String id;

        private String dapan;

        public String getA ()
        {
            return a;
        }

        public void setA (String a)
        {
            this.a = a;
        }

        public String getB ()
        {
            return b;
        }

        public void setB (String b)
        {
            this.b = b;
        }

        public String getC ()
        {
            return c;
        }

        public void setC (String c)
        {
            this.c = c;
        }

        public String getD ()
        {
            return d;
        }

        public void setD (String d)
        {
            this.d = d;
        }

        public String getCauhoi ()
        {
            return cauhoi;
        }

        public void setCauhoi (String cauhoi)
        {
            this.cauhoi = cauhoi;
        }

        public String getIdcate ()
        {
            return idcate;
        }

        public void setIdcate (String idcate)
        {
            this.idcate = idcate;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getDapan ()
        {
            return dapan;
        }

        public void setDapan (String dapan)
        {
            this.dapan = dapan;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [a = "+a+", b = "+b+", c = "+c+", d = "+d+", cauhoi = "+cauhoi+", idcate = "+idcate+", id = "+id+", dapan = "+dapan+"]";
        }
    }

}
