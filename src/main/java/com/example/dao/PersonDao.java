package com.example.dao;

import com.example.models.Person;

import java.util.List;

public interface PersonDao {

    public List<Person> index();
    public Person show(int id);
    public void save(Person person);
    public void update(int id, Person updatedPerson);
    public void delete(int id);

}
