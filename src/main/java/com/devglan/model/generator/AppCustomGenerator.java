package com.devglan.model.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppCustomGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {

        Connection connection = session.connection();

        try {
            Statement statement = connection.createStatement();
            String nomeTabelaSeq = obj.getClass().getSimpleName().toLowerCase()+"_seq";

            ResultSet rs = statement.executeQuery("SELECT next_value FROM " + nomeTabelaSeq);

            if (rs.next()) {
                int id = rs.getInt(1) + 1;
                String generatedId = new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                rs.close();


                Integer nextValue = new Integer(id);

                if (statement.executeUpdate(" update " + nomeTabelaSeq + " set next_value=" + nextValue) > 0) {
                    return nextValue;
                } else {
                    return null; // System.out.println("Seq não atualizado na tabela "+nomeTabelaSeq);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}