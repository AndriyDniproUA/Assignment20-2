package com.sav;

import com.sav.entities.Order;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@RequiredArgsConstructor
public class SaveProcessOrder implements ProcessOrder{
    private String filePath;
    private ProcessOrder processor;

    public SaveProcessOrder(String filePath, ProcessOrder processor) {
        this.filePath = filePath;
        this.processor = processor;
    }

    public SaveProcessOrder(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void process(Order o) {

        System.out.println("ORDER SAVING IN ACTION");
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Path.of(filePath),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.clear();
            buffer.put((serialize(o) + "\n").getBytes(StandardCharsets.UTF_8));
            buffer.limit(buffer.position());
            buffer.position(0);
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (processor!=null) processor.process(o);

    }

    public String serialize(Order o) {
        return String.format("%s[%s:%s]",
                o.getID(),
                o.getFrom(),
                o.getText());

    }
}
