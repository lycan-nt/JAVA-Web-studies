package com.globallabs.springwebmvc.repository;

import com.globallabs.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> jediList;

    public JediRepository()
    {
        jediList = new ArrayList<Jedi>();
        jediList.add(new Jedi("Felipe", "D. Santos"));
    }

    public List<Jedi> getAllJedi()
    {
        return this.jediList;
    }

    public void add(Jedi jedi)
    {
        this.jediList.add(jedi);
    }
}
