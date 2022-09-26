/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package es.alfmarmes.disnyoejercicios1;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

/**
 *
 * @author Alfre
 */
public class DisnyoEjercicios1 {

    public static void main(String[] args) {
        Options options = new Options();

        options.addOption("w", "hello-world", false, "imprime hola mundo");

        OptionGroup gr = new OptionGroup();
        gr.addOption(new Option("c", "cruel", false, "anyade adjetivo cruel a mundo"));
        gr.addOption(new Option("n", "nice", false, "anyade adjetivo bonito a mundo"));
        options.addOptionGroup(gr);

        options.addOption("y", "years", true, "imprime anyos n tras hello world");
        options.addOption("h", "help", false, "shows help");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {

                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("imprime hola mundo y variaciones extra", options);

            } else {
                if (cmd.hasOption("w")) {
                    System.out.print("Hola mundo");

                    if (cmd.hasOption("c")) {
                        System.out.print(" cruel");
                    } else if (cmd.hasOption("n") || cmd.hasOption("nice")) {
                        System.out.print(" bonito");
                    }

                    if (cmd.hasOption("y")) {
                        try {
                            System.out.print(" tras " + Integer.parseInt(cmd.getOptionValue("y")) + " años de vida.");
                        } catch (Exception ex2) {
                            System.err.println("La opcion -y|--year debe recibir un valor numérico");
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
