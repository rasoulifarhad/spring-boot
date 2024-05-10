package com.farhad.example.dddorderexample.domain.shared.specification;

public abstract class AbstractSpecification<T> implements  Specification<T>{

    @Override
    public abstract boolean isSatisfiedBy(T t) ;

    @Override
    public Specification<T> and(Specification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }

    @Override
    public Specification<T> not(Specification<T> specification) {
        return new NotSpecification<T>(specification);
    }

    @Override
    public Specification<T> or(Specification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

}
