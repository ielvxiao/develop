# 使用Builder模式之前的创建java bean的方法

## 1. 构造器
   问题：
   - 如果属性特别多，则需要重载很多构造器，每次传入参数的时候都特别繁琐，而且需要注意顺序。
## 2. set&get注入属性
    问题
    -  因为构造过程被分到了几个调用中，在构造中 JavaBean 可能处于不一致的状态。不能保证一次注入全部所需要的属性。
# builder模式
```
class Student {
    private String name;
    private int age;
    private int grade;

    Student(final String name, final int age, final int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public static Student.StudentBuilder builder() {
        return new Student.StudentBuilder();
    }

    private Student() {
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setGrade(final int grade) {
        this.grade = grade;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Student)) {
            return false;
        } else {
            Student other = (Student)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label31: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label31;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label31;
                    }

                    return false;
                }

                if (this.getAge() != other.getAge()) {
                    return false;
                } else {
                    return this.getGrade() == other.getGrade();
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        int result = result * 59 + ($name == null ? 43 : $name.hashCode());
        result = result * 59 + this.getAge();
        result = result * 59 + this.getGrade();
        return result;
    }

    public String toString() {
        return "Student(name=" + this.getName() + ", age=" + this.getAge() + ", grade=" + this.getGrade() + ")";
    }

    public static class StudentBuilder {
        private String name;
        private int age;
        private int grade;

        StudentBuilder() {
        }

        public Student.StudentBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Student.StudentBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public Student.StudentBuilder grade(final int grade) {
            this.grade = grade;
            return this;
        }

        public Student build() {
            return new Student(this.name, this.age, this.grade);
        }

        public String toString() {
            return "Student.StudentBuilder(name=" + this.name + ", age=" + this.age + ", grade=" + this.grade + ")";
        }
    }
}
```