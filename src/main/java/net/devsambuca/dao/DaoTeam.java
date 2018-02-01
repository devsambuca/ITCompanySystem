package net.devsambuca.dao;

import net.devsambuca.model.Developer;
import net.devsambuca.model.Team;

import java.io.*;
import java.util.*;

public class DaoTeam implements DaoImp<Team> {

    public static final String FILE_PATH = "src/main/resources/teams.txt";

    public void create(Team team) {
        List<Team> teams = new ArrayList<>();
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
            File teamFile = new File(FILE_PATH);
            Scanner teamScanner = new Scanner(teamFile);
            while (teamScanner.hasNext()) {
                Team team = new Team();
                String nextLine = teamScanner.nextLine();
                String[] teamData = nextLine.split(",");
                for (int i = 0; i < teamData.length; i++) {
                    if (teamData[i].isEmpty()) continue;

                    switch (i) {
                        case 0:
                            team.setId(Long.parseLong(teamData[i]));
                            continue;
                    }
                    if (i == teamData.length-1)
                        team.setName(teamData[i]);
                    else {
                        Set<Developer> developers = team.getDevelopers();
                        if (developers == null) developers = new HashSet<>();
                        DaoDeveloper daoDeveloper = new DaoDeveloper();
                        developers.add(daoDeveloper.read((Long.valueOf(teamData[i]))));
                        team.setDevelopers(developers);
                    }
                }

                if (id == team.getId())
                    System.out.println(team);

                    return team;

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
        try {
            File teamFile = new File(FILE_PATH);
            Scanner teamScanner = new Scanner(teamFile);
            List<Team> teamList = new ArrayList<>();
            while (teamScanner.hasNext()) {
                Team team = new Team();
                String nextLine = teamScanner.nextLine();
                String[] teamData = nextLine.split(",");

                team.setId(Long.parseLong(teamData[0]));
                team.setName(teamData[1]);
                for (int i = 0; i < teamData.length; i++) {
                    if (teamData[i].isEmpty()) continue;
                    if (i == teamData.length - 1) {
                        Set<Developer> developers = team.getDevelopers();
                        if (developers == null) developers = new HashSet<>();
                        DaoDeveloper daoDeveloper = new DaoDeveloper();
                        developers.add(daoDeveloper.read((Long.valueOf(teamData[i]))));
                        team.setDevelopers(developers);
                        teamList.add(team);
                    }
                }
            }
            return teamList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}