package com.BackEnd.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ObjectService<T> {

	public List<T> getAll();
	public T getOne(int id);
	public T save(T t);
	public T update(T t , int id);
	public boolean delete(int id);
}
