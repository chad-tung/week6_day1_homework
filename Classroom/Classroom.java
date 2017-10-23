public class Classroom {
    private Person[] students;

    public Classroom() {
        this.students = new Person[20];
    }

    public int studentCount() {
        int counter = 0;
        for (Person student : this.students) {
            if(student != null) {
                counter ++;
            }
        }
        return counter;
    }

    public boolean isClassFull() {
        return studentCount() == students.length;
    }

    public void add(Person student) {
        if(!isClassFull()) {
            int counter = studentCount();
            this.students[counter] = student;
        }
    }

    public void dismiss() {
        int counter = studentCount();
        for(int i=0; i < counter; i++) {
            this.students[i] = null;
        }
    }
}
