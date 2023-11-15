
import java.util.*;
import Commands.*;
import Given.*;
import Factorys.*;
import Memento.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vector<Team> Teams = new Vector<Team>();
        Stack<Command> undos = new Stack<Command>();
        Stack<Command> redos = new Stack<Command>();
        Caretaker ct = new Caretaker();

        // Change in Command have not feedback, must use array
        Team[] currTeam = new Team[1];

        String command;
        Command com;

        HashMap<String, TeamFactory> createTeamF = new HashMap<String, TeamFactory>();
        createTeamF.put("v", new VolleyballTeamFactory());
        createTeamF.put("f", new FootballTeamFactory());

        HashMap<Class<?>, String> createTeamString = new HashMap<Class<?>, String>();
        VolleyballTeam v = new VolleyballTeam(null);
        FootballTeam f = new FootballTeam(null);

        createTeamString.put(v.getClass(), "Volleyball");
        createTeamString.put(f.getClass(), "Football");

        HashMap<Class<?>, String> addPlayerPromptString = new HashMap<Class<?>, String>();
        addPlayerPromptString.put(v.getClass(), "Position (1 = attacker | 2 = defender ):-");
        addPlayerPromptString.put(f.getClass(),
                "Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):-");

        HashMap<Class<?>, int[]> addPlayerPosChoice = new HashMap<Class<?>, int[]>();
        int[] volleyPos = new int[] { 1, 2 };
        int[] footballPos = new int[] { 1, 2, 3, 4 };
        addPlayerPosChoice.put(v.getClass(), volleyPos);
        addPlayerPosChoice.put(f.getClass(), footballPos);

        HashMap<int[], String[]> volleyPositionNameHM = new HashMap<int[], String[]>();
        String[] volleyPosStrings = new String[] { "attacker", "defender" };
        volleyPositionNameHM.put(volleyPos, volleyPosStrings);

        HashMap<int[], String[]> footballPositionNameHM = new HashMap<int[], String[]>();
        String[] footballPosStrings = new String[] { "goal keeper", "defender", "midfielder", "forward" };
        footballPositionNameHM.put(footballPos, footballPosStrings);

        HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM = new HashMap<Class<?>, HashMap<int[], String[]>>();
        classPosNamHM.put(v.getClass(), volleyPositionNameHM);
        classPosNamHM.put(f.getClass(), footballPositionNameHM);

        HashMap<String, CommandFactory> cFactories = new HashMap<String, CommandFactory>();

        cFactories.put("c", new CreateTeamCommandFactory(sc, Teams, currTeam, undos, createTeamF, createTeamString));
        cFactories.put("g", new SetCurrentTeamCommandFactory(sc, Teams, currTeam));
        cFactories.put("a", new AddPlayerCommandFactory(sc, currTeam, undos, addPlayerPromptString,
                addPlayerPosChoice, classPosNamHM));
        cFactories.put("m",
                new ModifyPlayerPositionCommandFactory(currTeam, sc, ct, undos, addPlayerPosChoice, classPosNamHM));
        cFactories.put("d", new DeleteCommandFactory(sc, currTeam, undos));
        cFactories.put("s",
                new DisplayTeamCommandFactory(currTeam, classPosNamHM, addPlayerPosChoice, createTeamString));
        cFactories.put("p", new DisplayAllTeamCommandFactory(Teams));
        cFactories.put("t", new RenameTeamCommandFactory(sc, currTeam, undos, ct));
        cFactories.put("u", new UndoCommandFactory(undos, redos));
        cFactories.put("r", new RedoCommandFactory(undos, redos));
        cFactories.put("l", new displayUndoRedoCommandFactory(undos, redos));
        cFactories.put("x", new ExitCommandFactory());

        while (true) {
            System.out.println(
                    "Sport Teams Management System (STMS)\nc = create team, g = set current team, a = add player, m = modify player’s position, d = delete player, s = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");

            if (currTeam[0] != null) {
                System.out.println("The current team is " + currTeam[0].getTeamID() + " " + currTeam[0].getName());
            }
            System.out.println("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            command = sc.nextLine().toLowerCase().trim();
            switch (command) {
                case "c":
                    com = cFactories.get("c").createCommand();
                    com.execute();
                    break;
                case "g":
                    com = cFactories.get("g").createCommand();
                    com.execute();
                    break;
                case "a":
                    com = cFactories.get("a").createCommand();
                    com.execute();
                    break;
                case "m":
                    com = cFactories.get("m").createCommand();
                    com.execute();
                    break;
                case "d":
                    com = cFactories.get("d").createCommand();
                    com.execute();
                    break;
                case "s":
                    com = cFactories.get("s").createCommand();
                    com.execute();
                    break;
                case "p":
                    com = cFactories.get("p").createCommand();
                    com.execute();
                    break;
                case "t":
                    com = cFactories.get("t").createCommand();
                    com.execute();
                    break;
                case "u":
                    com = cFactories.get("u").createCommand();
                    com.execute();
                    break;
                case "r":
                    com = cFactories.get("r").createCommand();
                    com.execute();
                    break;
                case "l":
                    com = cFactories.get("l").createCommand();
                    com.execute();
                    break;
                case "x":
                    com = cFactories.get("x").createCommand();
                    com.execute();
                    break;
            }
        }
    }
}