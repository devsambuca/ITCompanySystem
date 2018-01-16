package net.devsambuca.dao;

import net.devsambuca.model.Team;
import java.io.*;
import java.util.*;

public class IDaoTeam implements IDao<Team> {

    public static final String FILE_PATH = "teams.txt";

    public void create(Team team) {
        Set<Team> teams = new HashSet<Team>();
        teams.add(team);
        Writer writer = null;
        String str = team.getId() + "," + team.getName();
        try {
            writer = new FileWriter(FILE_PATH, true);
            writer.write(str + '\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Team read(long id) {
        try {
            // find the file with the team date
            File listTeamFile = new File(FILE_PATH);
            Scanner listTeamScanner = new Scanner(listTeamFile);
            while (listTeamScanner.hasNext()) {
                Team team = new Team();
                String nextLine = listTeamScanner.nextLine();
                String[] listTeamData = nextLine.split(",");
                team.setId((Long.parseLong(listTeamData[0])));
                team.setName(listTeamData[1]);

                if (id == team.getId()) {
                    return team;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public void update(Team team) {
        List<Team> listTeam = getAll();
        Iterator<Team> iDev = listTeam.iterator();
        while (iDev.hasNext()) {
            Team s = iDev.next();
            if (s.getId() == team.getId())
                iDev.remove();
        }
        listTeam.add(team);
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Team line : listTeam) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        List<Team> listTeam = getAll();
        Iterator<Team> iDev = listTeam.iterator();
        while (iDev.hasNext()) {
            Team s = iDev.next();
            if (s.getId() == id)
                iDev.remove();
        }
        Writer writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            for (Team d : listTeam) {
                writer.write(String.valueOf(d));
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Team> getAll() {
        List<Team> listTeamList = new ArrayList<Team>();
        try {
            // find the file with the team date
            File listTeamFile = new File(FILE_PATH);
            Scanner listTeamScanner = new Scanner(listTeamFile);
            while (listTeamScanner.hasNext()) {
                Team team = new Team();
                String nextLine = listTeamScanner.nextLine();
                String[] listTeamData = nextLine.split(",");
                team.setId((Long.parseLong(listTeamData[0])));
                team.setName(listTeamData[1]);
                listTeamList.add(team);
            }
            return listTeamList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}