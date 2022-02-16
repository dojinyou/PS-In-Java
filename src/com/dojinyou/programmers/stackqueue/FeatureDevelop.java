import java.util.*;

class FeatureDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        Product product = new Product();
        product.addFeatures(progresses, speeds);

        while (!product.isCompleted()) {
            product.develop();
            int numOfDeployFeatures = product.deploy();
            if (numOfDeployFeatures != 0) {
                answer.add(numOfDeployFeatures);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
class Product {
    private ArrayDeque<Feature> developFeatureList;
    private ArrayDeque<Feature> deployedFeatureList;

    Product(){
        this.developFeatureList = new ArrayDeque<>();
        this.deployedFeatureList = new ArrayDeque<>();
    }

    public void addFeature(Feature newFeature) {
        this.developFeatureList.add(newFeature);
    }

    public boolean addFeatures(int[] progresses, int[] speeds) {
        if (progresses.length != speeds.length) return false;
        int numOfFeatures = progresses.length;
        for(int i = 0; i<numOfFeatures;i++){
            this.addFeature(new Feature(i, progresses[i], speeds[i]));
        }
        return true;
    }

    public void develop() {
        for (Feature feature : developFeatureList) {
            if (!feature.isCompleted()) {feature.develop();}
        }
    }
    public int deploy() {
        int numOfDeployFeatures = 0;
        int numOfDevelopFeatures = this.developFeatureList.size();
        while (!this.isCompleted()) {
            if (!developFeatureList.peek().isCompleted()) break;
            Feature completedFeature = developFeatureList.pop();
            completedFeature.deploy();
            deployedFeatureList.add(completedFeature);
            numOfDeployFeatures += 1;
        }
        return numOfDeployFeatures;
    }

    public boolean isCompleted() {
        return developFeatureList.size() == 0;
    }
}
class Feature {
    private final int ID;
    private final int SPEED;
    private int progress;
    private boolean isDeploy = false;

    Feature(int ID, int progress, int speed) {
        this.ID = ID;
        this.SPEED = speed;
        this.progress = progress;
    }
    public int getProgress() {return this.progress;}
    public void setProgress(int progress) {this.progress = progress;}
    public int getSpeed() {return this.SPEED;}
    public int getID() {return this.ID;}

    public void develop() {
        int nextProgress = this.getProgress() + this.getSpeed();
        this.setProgress(Math.min(100,nextProgress));
    }
    public boolean isCompleted() {return this.getProgress() == 100;}

    public void deploy() {this.isDeploy = true;}
}