package com.example.lib.Model;

import java.util.List;

public class CategoryModel
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
        private String name;

        private String id;

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [name = "+name+", id = "+id+"]";
        }
    }
}
