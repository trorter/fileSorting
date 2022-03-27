package ru.ledovskikh.andrei.impl.generator;

import ru.ledovskikh.andrei.impl.FileHelper;
import ru.ledovskikh.andrei.model.generator.RandomFileGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Andrey Ledovskikh
 */
public class RandomFileGeneratorImpl implements RandomFileGenerator {

    private static final List<String> RANDOM_WORDS_LIST = new ArrayList<>(
        Arrays.asList(
                "ablaze ",
                "drop ",
                "consider ",
                "snore ",
                "strengthen ",
                "stain ",
                "gusty ",
                "approve ",
                "incompetent ",
                "gamy ",
                "trust ",
                "fixed ",
                "sassy ",
                "committee ",
                "phobic ",
                "shiver ",
                "knowing ",
                "delay ",
                "acoustics ",
                "obeisant ",
                "system ",
                "spiky ",
                "illegal ",
                "simple ",
                "courageous ",
                "mitten ",
                "crawl ",
                "shape ",
                "relation ",
                "brake ",
                "visit ",
                "defiant ",
                "blue ",
                "mighty ",
                "beds ",
                "need ",
                "mean ",
                "teeny ",
                "dispensable ",
                "pets ",
                "high ",
                "flashy ",
                "call ",
                "obsequious ",
                "well-made ",
                "miniature ",
                "boiling ",
                "staking ",
                "tangible ",
                "mountain ",
                "apathetic ",
                "reminiscent ",
                "amuck ",
                "prick ",
                "share ",
                "selective ",
                "reaction ",
                "bedroom ",
                "ritzy ",
                "detailed ",
                "building ",
                "store ",
                "knife ",
                "cross ",
                "fumbling ",
                "bridge ",
                "plot ",
                "fail ",
                "paltry ",
                "coast ",
                "flippant ",
                "size ",
                "aspiring ",
                "load ",
                "sprout ",
                "precede ",
                "battle ",
                "superficial ",
                "sock ",
                "grade ",
                "torpid ",
                "wandering ",
                "coordinated ",
                "like ",
                "plane ",
                "whine ",
                "witty ",
                "water ",
                "lavish ",
                "grateful ",
                "rabbit ",
                "form ",
                "scratch ",
                "hose ",
                "top ",
                "lake ",
                "laughable ",
                "nonstop ",
                "decide ",
                "messy "
                )
    );

    private final String path;

    private final int totalStringCount;
    private final int maxWordsInRow;

    public RandomFileGeneratorImpl(String path, int totalStringCount, int maxWordsInRow) {
        this.path = path;
        this.totalStringCount = totalStringCount;
        this.maxWordsInRow = maxWordsInRow;
    }

    @Override
    public void generateRandomFile() throws IOException {
        FileHelper.checkAndRefreshFile(this.path);

        FileWriter fileWriter = new FileWriter(this.path);

        final Random random = new Random();
        for (int i = 0; i < this.totalStringCount; i++) {
            final StringBuilder randomString = new StringBuilder(1000);
            final int wordsInString = random.nextInt(this.maxWordsInRow) + 1;

            for (int j = 0; j < wordsInString; j++) {
                randomString.append(RANDOM_WORDS_LIST.get(random.nextInt(RANDOM_WORDS_LIST.size())));
            }

            randomString.append(System.getProperty("line.separator"));
            fileWriter.write(randomString.toString());
        }

        fileWriter.close();
        System.out.println("The new file generated with path: " + this.path);
    }
}
