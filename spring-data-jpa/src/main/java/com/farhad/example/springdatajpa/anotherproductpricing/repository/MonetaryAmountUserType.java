package com.farhad.example.springdatajpa.anotherproductpricing.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.money.MonetaryAmount;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.javamoney.moneta.Money;

import com.farhad.example.springdatajpa.anotherproductpricing.utils.MoneyUtils;

public class MonetaryAmountUserType implements UserType {

    private static final int [] SQL_TYPES = {Types.NUMERIC, Types.VARCHAR};
    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return MonetaryAmount.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if ( x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, 
                                String[] names, 
                                SharedSessionContractImplementor session, 
                                Object owner) throws HibernateException, SQLException {
        BigDecimal value = rs.getBigDecimal(names[0]);
        if (rs.wasNull()){
            return null;
        }
        String currencyCode = rs.getString(names[1]);
        return Money.of(value, currencyCode);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, 
                            Object value, 
                            int index, 
                            SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.NUMERIC);
            st.setNull(index + 1 , Types.VARCHAR);
        } else {
            MonetaryAmount monetaryAmount = (MonetaryAmount) value;
            BigDecimal amount = MoneyUtils.extractAmount(monetaryAmount);
            st.setBigDecimal(index, amount);
            String currencyCode = MoneyUtils.extractCurrencyCode(monetaryAmount);
            st.setString(index + 1 , currencyCode);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deepCopy'");
    }

    @Override
    public boolean isMutable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMutable'");
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disassemble'");
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assemble'");
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }
    
}
