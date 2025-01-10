class Badge {
    public static void main(String[] args) {
        Badge badge = new Badge();
        System.out.println(badge.print(734, "Ernest Johnny Payne", "Strategic Communication"));
        // => "[734] - Ernest Johnny Payne - STRATEGIC COMMUNICATION"
        // "[id] - name - DEPARTMENT"
        System.out.println(badge.print(null, "Jane Johnson", "Procurement"));
        // => "Jane Johnson - PROCUREMENT"
        System.out.println(badge.print(254, "Charlotte Hale", null));
        System.out.println(badge.print(null, "Charlotte Hale", null));

    }

    public String print(Integer id, String name, String department) {
        if (department == null) {
            department = "OWNER";
        }
        if (id == null) {
            return String.format("%s - %s", name, department.toUpperCase());
        }
        return String.format("[%d] - %s - %s", id, name, department.toUpperCase());
        //better solution from community
/*         return String.format("%s%s - %s",
            id != null ? String.format("[%d] - ", id) : "",
            name,
            department != null ? department.toUpperCase() : "OWNER");
             */
    }
}
