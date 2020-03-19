package com.company;
import com.sun.deploy.net.MessageHeader;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");

        List<Resident> residentList = Stream.of(r0,r1,r2,r3).collect(Collectors.toCollection(ArrayList::new)); //creeaza un ArrayList si pune obiectele in el

        Collections.sort(residentList,
                ((res1, res2) -> r2.getName().compareTo(r1.getName())));

        for (Resident res : residentList) {
            System.out.println(res.getName());
        }

        Hospital h0 = new Hospital("H0",1);
        Hospital h1 = new Hospital("H1",2);
        Hospital h2 = new Hospital("H2",2);

        Set<Hospital> hospitals = Stream.of(h0,h1,h2).collect(Collectors.toCollection(TreeSet::new)); //creeaza un TreeSet si pune obiectele in el

        Map<Resident, Set<Hospital>> resPrefMap = getResPrefMap(residentList,hospitals);

        Map<Hospital, List<Resident>> hosPrefMap = getHosPrefMap(residentList,hospitals);

        for( Map.Entry<Resident, Set<Hospital>> x : resPrefMap.entrySet()) {
            System.out.print(x.getKey().getName() +": ( ");
            for (Hospital hos: x.getValue() ) {
                System.out.print(hos.getName() +" ");
            }
            System.out.println(")");
        }

        System.out.println();

        for( Map.Entry<Hospital, List<Resident>> x : hosPrefMap.entrySet()) {
            System.out.print(x.getKey().getName() +": ( ");
            for (Resident res: x.getValue() ) {
                System.out.print(res.getName() +" ");
            }
            System.out.println(")");
        }
        System.out.println();

        residentList.stream().filter(resident -> (resPrefMap.get(resident).containsAll(Arrays.asList(h0,h2)))).forEach(resident ->System.out.print(resident.getName() +' '));
        /*in lista cu rezidenti punem toate obiectele intr-un stream si le filtram in fctie de o conditie : mapul resPrefMap sa contina obiectele ho,h2, date sub forma
        unei liste la cheia resident. Prin filtrare, pastreaza in stream doar rezidentii corecti, dupa care ii afiseaza.*/
        System.out.println();

        hospitals.stream().filter(hospital -> (hosPrefMap.get(hospital).get(0).equals(r0))).forEach(hospital -> System.out.print(hospital.getName() +' '));
    }

    private static Map<Resident, Set<Hospital>> getResPrefMap(List<Resident> residents, Set<Hospital> hospitals){
        Map<Resident, Set<Hospital>> map1 = new LinkedHashMap<Resident, Set<Hospital>>();

        map1.put(residents.get(0), hospitals.stream().filter(hospital -> (hospital.getName().equals("H0") || hospital.getName().equals("H1") || hospital.getName().equals("H2"))).collect(Collectors.toSet()));
        map1.put(residents.get(1), hospitals.stream().filter(hospital -> (hospital.getName().equals("H0") || hospital.getName().equals("H1") || hospital.getName().equals("H2"))).collect(Collectors.toSet()));
        map1.put(residents.get(2), hospitals.stream().filter(hospital -> (hospital.getName().equals("H0") || hospital.getName().equals("H1"))).collect(Collectors.toSet()));
        map1.put(residents.get(3), hospitals.stream().filter(hospital -> (hospital.getName().equals("H0") || hospital.getName().equals("H2"))).collect(Collectors.toSet()));

        return map1;
        // functia creeaza un map LinkedHashMap si adauga elementele in el
    }

    private static Map<Hospital, List<Resident>> getHosPrefMap(List<Resident> residents, Set<Hospital> hospitals){
        Map<Hospital, List<Resident>> map = new HashMap<Hospital, List<Resident>>();
        Iterator<Hospital> iter= hospitals.iterator();
        map.put(iter.next(),Stream.of(residents.get(3),residents.get(0),residents.get(1),residents.get(2)).collect(Collectors.toList()));
        map.put(iter.next(),Stream.of(residents.get(0),residents.get(2),residents.get(1)).collect(Collectors.toList()));
        map.put(iter.next(),Stream.of(residents.get(0),residents.get(1),residents.get(3)).collect(Collectors.toList()));

        return map;
        // functia creeaza un map LinkedHashMap si adauga elementele in el
    }

}
