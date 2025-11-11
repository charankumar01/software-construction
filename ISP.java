interface CloudHostingProvider {
    public abstract void createServer(String region);

    public abstract void listServers(String region);
}

interface CDNProvider {
    public abstract String getCDNAddress();
}

interface CloudStoringProvider {
    public abstract void storeFile(String region);

    public abstract String getFile(String region);
}

class Amazon implements CloudHostingProvider, CDNProvider, CloudStoringProvider {
    @Override
    public void createServer(String region) {
        System.out.println("Amazon: Creating server in " + region);
    }

    @Override
    public void listServers(String region) {
        System.out.println("Amazon: Listing servers in " + region);
    }

    @Override
    public String getCDNAddress() {
        return "Amazon CDN Address";
    }

    @Override
    public void storeFile(String region) {
        System.out.println("Amazon: Storing file in " + region);
    }

    @Override
    public String getFile(String region) {
        return "Amazon: Retrieving file from " + region;
    }
}

class Dropbox implements CloudStoringProvider {
    @Override
    public void storeFile(String name) {
        System.out.println("Dropbox: Storing file: " + name);
    }

    @Override
    public String getFile(String name) {
        return "Dropbox: Retrieved file data for " + name;
    }
}

public class ISP {
    public static void main(String[] args) {
        System.out.println("Interface Segregation Principle");
        Amazon amazon = new Amazon();
        System.out.println("--- Amazon Services ---");
        amazon.createServer("us-east-1");
        amazon.listServers("ListServers.txt");
        System.out.println("CDN Address: " + amazon.getCDNAddress());

        Dropbox dropbox = new Dropbox();
        System.out.println("--- Dropbox Services ---");
        dropbox.storeFile("Lab Submission.docx");
        dropbox.getFile("Lab Submission.docx");

        CloudStoringProvider cloud = amazon;
        System.out.println("--- Cloud Storing via Amazon ---");
        cloud.storeFile("backup.zip");
    }
}
