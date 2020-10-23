package com.person.api.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person implements Serializable {

  private static final long serialVersionUID = -161706415689290466L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String document;
  private Boolean fingerprint;
  private Boolean blacklist;

}
