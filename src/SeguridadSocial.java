import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SeguridadSocial {
    private List<Persona> personasList;

    public SeguridadSocial() {
        personasList = new ArrayList<>();

    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona Persona) {personasList.add(Persona);}

    public void bajaPersona(String dni) {
        personasList.removeIf(Persona -> Persona.getDni().equals(dni));
    }


    public Persona obtenerPersonaPorDNI(String dni) {

        Persona encontrada = null;

        for(Persona persona:personasList){
            if(persona.getDni().equals(dni)){
                encontrada=persona;
                break;
            }
        }
        return encontrada;

    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        Persona encontrada = null;

        for(Persona persona:personasList){
            if(persona.getNumSS().equals(numSS)){
                encontrada=persona;
                break;
            }
        }
        return encontrada;

    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        return personasList.stream().filter(persona -> persona.getSalario()> min && persona.getSalario()< max).collect(Collectors.toList());
    }


    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personasList.stream().filter(persona -> persona.getEdad()> edad ).collect(Collectors.toList());
    }


    public Persona obtenerPersonaPorSalarioMinimo(){
        Persona min= null;
        for (Persona persona: personasList){

            if(min==null || persona.getSalario()<min.getSalario()){
                min=persona;
            }
        }
        return min;
    }

    public Persona obtenerPersonaPorSalarioMaximo(){

        Persona max = null;
        for (Persona persona: personasList){

            if(max==null || persona.getSalario()>max.getSalario()){
                max=persona;
            }
        }
        return max;
    }

    public List<Persona> obtenerTodas(){
        return personasList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}


























































/*
HASHMAPS

        import java.util.*;

public class SeguridadSocialHashMap{
    private HashMap<String, Persona> personasMapPorSS;
    private HashMap<String, Persona> personasMapPorDNI;
    public SeguridadSocialHashMap() {
        personasMapPorSS = new HashMap<String, Persona>();
        personasMapPorDNI = new HashMap<String, Persona>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona Persona) {
        personasMapPorSS.put(Persona.getNum_seguridad_social(),Persona);
        personasMapPorDNI.put(Persona.getDNI(),Persona);
        System.out.println("PERSONAGETSALARIO"+Persona.getSalario());
        System.out.println("PERSONAHASHMAPGETSALARIO"+obtenerPersonaPorDNI(Persona.getDNI()));
    }

    public void bajaPersona(String dni) {
        personasMapPorSS.remove(obtenerPersonaPorDNI(dni));
        personasMapPorDNI.remove(dni);
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        return personasMapPorDNI.get(dni);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        return personasMapPorSS.get(numSS);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        List<Persona> personasListRangoSalarial = new ArrayList<>();
        Iterator iterator = personasMapPorSS.values().iterator();
        while (iterator.hasNext()) {
            Persona p = (Persona)iterator.next();
            if (p.getSalario() >= min && p.getSalario() <= max){
                personasListRangoSalarial.add(p);
            }
        }
        return personasListRangoSalarial;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){
        List<Persona> personasListMayoresQue= new ArrayList<>();
        Iterator iterator = personasMapPorSS.values().iterator();
        while (iterator.hasNext()) {
            Persona p = (Persona)iterator.next();
            if (p.getEdad() >edad){
                personasListMayoresQue.add(p);
            }
        }
        return personasListMayoresQue;
    }

    public HashMap<String,Persona> obtenerTodas(){
        return personasMapPorSS;
    }

    public Optional<Persona> obtenerPersonaPorSalarioMaximo(){
       /* Persona personaMaximo = null;
        double doubleMaximo = 0;
        Iterator iterator = personasMapPorSS.values().iterator();
        while (iterator.hasNext()) {
            Persona p = (Persona)iterator.next();
            if (p.getSalario() >=doubleMaximo){
                personaMaximo = p;
                doubleMaximo = p.getSalario();
            }
        }
        return personaMaximo;
        return personasMapPorDNI.values().stream().max(Comparator.comparing(Persona::getSalario));
    }

    public Optional<Persona> obtenerPersonaPorSalarioMinimo(){
        /*Persona personaMinimo = null;
        double doubleMinimo = 0;
        Iterator iterator = personasMapPorSS.values().iterator();
        while (iterator.hasNext()) {
            Persona p = (Persona)iterator.next();
            if (p.getSalario() >=doubleMinimo){
                personaMinimo = p;
                doubleMinimo = p.getSalario();
            }
        }
        return personaMinimo;
        return personasMapPorDNI.values().stream().min(Comparator.comparing(Persona::getSalario));

    }

    public List<Persona> ordenarPorDNI(){
        List<Persona> personasPorDNI = new ArrayList<>(personasMapPorDNI.values());

        personasPorDNI.sort(Comparator.comparing(Persona::getDNI));

        return personasPorDNI;
    }

    public List<Persona> ordenarPorSS(){
        return null;
    }

    public List<Persona> ordenarPorSalario(){
        return null;
    }

    public List<Persona> edad(){
        return null;
    }

    @Override
    public String toString() {
        return "SeguridadSocialArrayList{" +
                "personasMapPorSS=" + personasMapPorSS +
                '}';
    }

}*/