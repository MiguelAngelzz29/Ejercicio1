package es.miguel.ejercicio1;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Ejercicio1 {

    public static void main(String[] args) {

        int n = 0;
        

        ///////1.FASE DE DEFINICIÓN
        Options options = new Options();
        options.addOption("w", false, "Mostrar hello world");
        options.addOption("h", "help", false, "Mostrar ayuda");
        options.addOption("y", "years", true, "Mostrar años");

        OptionGroup group = new OptionGroup();
        group.addOption(new Option("n", "nice", false, "Hola mundo bonito"));
        group.addOption(new Option("c", "cruel", false, "Hola mundo cruel"));
        options.addOptionGroup(group);

        //////2. FASE DE PARSEO
        CommandLine cmd = null;
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options, args);

        } catch (ParseException ex) {

            ex.printStackTrace(System.err);
        }

        ///////3. FASE DE INTERROGACIÓN
        if (cmd.hasOption("w")) {
            System.out.println("Hello World!");
        }
        if (cmd.hasOption("n")) {
            System.out.println("Hola mundo bonito!");
        }
        if (cmd.hasOption("c")) {
            System.out.println("Hola mundo cruel");
        }

        if (cmd.hasOption("h")) {
            new HelpFormatter().printHelp(Ejercicio1.class.getCanonicalName(), options);

        }
        if (cmd.hasOption("y")) {
            n = Integer.parseInt(cmd.getOptionValue("y"));
            System.out.println("tras " + n + " años de vida");
        }
    }
}
