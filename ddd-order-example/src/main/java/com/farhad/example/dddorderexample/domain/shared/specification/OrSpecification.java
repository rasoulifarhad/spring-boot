package com.farhad.example.dddorderexample.domain.shared.specification;

public class OrSpecification<T> extends AbstractSpecification<T>  {

    private Specification<T> left;
    private Specification<T> right;

    public OrSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return left.isSatisfiedBy(t) || right.isSatisfiedBy(t);
    }

}
