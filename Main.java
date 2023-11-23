
import java.util.*;
import Commands.*;
import Given.*;
import Factorys.*;
import Memento.*;

public class Main {
    // declares a `Scanner` object named `sc` for user input.
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // - It creates a `Vector` called `Teams` to store instances of the `Team`
        // class.
        Vector<Team> Teams = new Vector<Team>();
        // - It creates two stacks of `Command` objects named `undos` and `redos`.
        Stack<Command> undos = new Stack<Command>();
        Stack<Command> redos = new Stack<Command>();
        // - It creates a `Caretaker` object named `ct` for handling mementos (used
        // later for undo and redo functionality).
        Caretaker ct = new Caretaker();
        // - It declares an array of `Team` objects called `currTeam` to store the
        // current team (used as a reference to the current team being manipulated).
        // Change in Command have not feedback, must use array
        Team[] currTeam = new Team[1];
        String command;
        Command com;
        // - `createTeamF`: Maps strings ("v" and "f") to `TeamFactory` objects
        // (`VolleyballTeamFactory` and `FootballTeamFactory`).
        HashMap<String, TeamFactory> createTeamF = new HashMap<String, TeamFactory>();
        createTeamF.put("v", new VolleyballTeamFactory());
        createTeamF.put("f", new FootballTeamFactory());
        // - `createTeamString`: Maps `Class` objects (`VolleyballTeam` and
        // `FootballTeam`) to strings ("Volleyball" and "Football").
        HashMap<Class<?>, String> createTeamString = new HashMap<Class<?>, String>();
        VolleyballTeam v = new VolleyballTeam(null);
        FootballTeam f = new FootballTeam(null);
        createTeamString.put(v.getClass(), "Volleyball");
        createTeamString.put(f.getClass(), "Football");
        // - `addPlayerPromptString`: Maps `Class` objects to strings representing
        // prompts for adding players.
        HashMap<Class<?>, String> addPlayerPromptString = new HashMap<Class<?>, String>();
        addPlayerPromptString.put(v.getClass(), "Position (1 = attacker | 2 = defender ):-");
        addPlayerPromptString.put(f.getClass(),
                "Position (1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):-");
        // - `addPlayerPosChoice`: Maps `Class` objects to arrays of integers
        // representing choices for player positions.
        HashMap<Class<?>, int[]> addPlayerPosChoice = new HashMap<Class<?>, int[]>();
        int[] volleyPos = new int[] { 1, 2 };
        int[] footballPos = new int[] { 1, 2, 3, 4 };
        addPlayerPosChoice.put(v.getClass(), volleyPos);
        addPlayerPosChoice.put(f.getClass(), footballPos);
        // - `volleyPositionNameHM` and `footballPositionNameHM`: Maps arrays of
        // integers (player positions) to arrays of strings (position names).
        HashMap<int[], String[]> volleyPositionNameHM = new HashMap<int[], String[]>();
        String[] volleyPosStrings = new String[] { "attacker", "defender" };
        volleyPositionNameHM.put(volleyPos, volleyPosStrings);

        HashMap<int[], String[]> footballPositionNameHM = new HashMap<int[], String[]>();
        String[] footballPosStrings = new String[] { "goal keeper", "defender", "midfielder", "forward" };
        footballPositionNameHM.put(footballPos, footballPosStrings);
        // - `classPosNamHM`: Maps `Class` objects to the corresponding position name
        // maps.
        HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM = new HashMap<Class<?>, HashMap<int[], String[]>>();
        classPosNamHM.put(v.getClass(), volleyPositionNameHM);
        classPosNamHM.put(f.getClass(), footballPositionNameHM);
        // - `cFactories`: Maps strings representing command codes to various
        // `CommandFactory` objects responsible for creating specific commands.
        HashMap<String, CommandFactory> cFactories = new HashMap<String, CommandFactory>();

        cFactories.put("c", new CreateTeamCommandFactory(sc, Teams, currTeam, undos, createTeamF, createTeamString));
        cFactories.put("g", new SetCurrentTeamCommandFactory(sc, Teams, currTeam));
        cFactories.put("a", new AddPlayerCommandFactory(sc, currTeam, undos, addPlayerPromptString,
                addPlayerPosChoice, classPosNamHM));
        cFactories.put("m",
                new ModifyPlayerPositionCommandFactory(currTeam, sc, ct, undos, addPlayerPosChoice, classPosNamHM));
        cFactories.put("d", new DeleteCommandFactory(sc, currTeam, undos));
        cFactories.put("s",
                new DisplayTeamCommandFactory(currTeam, classPosNamHM, addPlayerPosChoice));
        cFactories.put("p", new DisplayAllTeamCommandFactory(Teams));
        cFactories.put("t", new RenameTeamCommandFactory(sc, currTeam, undos, ct));
        cFactories.put("u", new UndoCommandFactory(undos, redos));
        cFactories.put("r", new RedoCommandFactory(undos, redos));
        cFactories.put("l", new displayUndoRedoCommandFactory(undos, redos));
        cFactories.put("x", new ExitCommandFactory());
        // - The code enters a while loop where it repeatedly displays a menu for the
        // user to interact with the STMS.
        while (true) {
            System.out.println(
                    "Sport Teams Management System (STMS)\nc = create team, g = set current team, a = add player, m = modify player’s position, d = delete player, s = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");

            if (currTeam[0] != null) {
                System.out.println("The current team is " + currTeam[0].getTeamID() + " " + currTeam[0].getName());
            }
            // - The user can enter different command codes to perform operations such as
            // creating a team, adding players, modifying player positions, etc.
            // - The appropriate factory object is used to create the corresponding command
            // based on the user's input.
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            command = sc.nextLine().toLowerCase().trim();
            switch (command) {
                case "c":
                    redos.clear();
                    com = cFactories.get("c").createCommand();
                    com.execute();
                    break;
                case "g":
                    com = cFactories.get("g").createCommand();
                    com.execute();
                    break;
                case "a":
                    redos.clear();
                    com = cFactories.get("a").createCommand();
                    com.execute();
                    break;
                case "m":
                    redos.clear();
                    com = cFactories.get("m").createCommand();
                    com.execute();
                    break;
                case "d":
                    redos.clear();
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
                    redos.clear();
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