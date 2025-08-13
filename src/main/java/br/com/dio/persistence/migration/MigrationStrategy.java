package br.com.dio.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class MigrationStrategy {

    private static final Logger LOGGER = Logger.getLogger(MigrationStrategy.class.getName());

    private final Connection connection;

    @SuppressWarnings("java:S106")
    public void executeMigration(){
        var originalOut = System.out;
        var originalErr = System.err;
        try(var fos = new FileOutputStream("liquibase.log")){
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));
            runLiquibaseMigration();
        } catch (IOException ex){
            LOGGER.log(Level.SEVERE, "Error writing Liquibase log file", ex);
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

    private void runLiquibaseMigration() {
        try {
            var jdbcConnection = new JdbcConnection(this.connection);
            var liquibase = new Liquibase(
                    "/db/changelog/db.changelog-master.yml",
                    new ClassLoaderResourceAccessor(),
                    jdbcConnection);
            liquibase.update();
        } catch (LiquibaseException e) {
            LOGGER.log(Level.SEVERE, "Liquibase migration failed", e);
        }
    }
}
