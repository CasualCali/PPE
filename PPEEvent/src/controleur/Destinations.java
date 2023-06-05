package controleur;

public class Destinations {
		private int destination_id;
		private String destination_name, destination_description, destination_image;

		public Destinations(int destination_id, String destination_name, String destination_description, String destination_image) {
			this.destination_id = destination_id;
			this.destination_name = destination_name;
			this.destination_description = destination_description;
			this.destination_image = destination_image;
		}

		public Destinations(String destination_name, String destination_image,String destination_description) {
			this.destination_id = 0;
			this.destination_name = destination_name;
			this.destination_image = destination_image;
			this.destination_description = destination_description;
		}

		public Destinations() {
			this.destination_id = 0;
			this.destination_name = "";
			this.destination_image = "";
			this.destination_description = "";
		}

		// Getters and Setters
		public int getdestination_id() {
			return destination_id;
		}

		public void setdestination_id(int destination_id) {
			this.destination_id = destination_id;
		}

		public String getdestination_name() {
			return destination_name;
		}

		public void setdestination_name(String destination_name) {
			this.destination_name = destination_name;
		}

		public String getdestination_image() {
			return destination_image;
		}

		public void setdestination_image(String destination_image) {
			this.destination_image = destination_image;
		}

		public String getdestination_description() {
			return destination_description;
		}

		public void setdestination_description(String destination_description) {
			this.destination_description = destination_description;
		}
}
