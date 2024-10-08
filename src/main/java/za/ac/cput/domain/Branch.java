package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "branch_seq")
    @SequenceGenerator(name = "branch_seq", sequenceName = "branch_seq", allocationSize = 1, initialValue = 100)
    private int branchId;
    private String branchName;
    private String address;

    @OneToMany
    private List<RentTruck> rentTrucks;

    protected Branch() {
    }

    public Branch(Builder builder) {
        this.branchId = builder.branchId;
        this.branchName = builder.branchName;
        this.address = builder.address;
  //      this.rentTrucks = builder.rentTrucks;
    }

    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getAddress() {
        return address;
    }

 //   public List<RentTruck> getRentTrucks() {
   //     return rentTrucks;
  //  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return branchId == branch.branchId && Objects.equals(branchName, branch.branchName) && Objects.equals(address, branch.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, branchName, address);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
            //    ", rentTrucks=" + rentTrucks +
                '}';
    }


    public static class Builder{
        private int branchId;
        private String branchName;
        private String address;
       // private List<RentTruck> rentTrucks;

        public Builder setBranchId(int branchId) {
            this.branchId = branchId;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setBranchName(String branchName) {
            this.branchName = branchName;
            return this;
        }

//        public Builder setRentTrucks(List<RentTruck> rentTrucks) {
//            this.rentTrucks = rentTrucks;
//            return this;
//        }

        public Builder copy(Branch branch){
            this.branchId = branch.branchId;
            this.branchName = branch.branchName;
            this.address = branch.address;
         //   this.rentTrucks = branch.rentTrucks;
            return this;
        }

        public Branch build() {
            return new Branch(this);
        }

    }
}
