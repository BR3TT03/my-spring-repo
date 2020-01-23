/**
 * @author Umesh Bhujel <yoomesbhujel@gmail.com>
 * Since Sep 24, 2019
 */
package com.ishanitech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishanitech.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
