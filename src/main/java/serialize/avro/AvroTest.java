package serialize.avro;

import model.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class AvroTest {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setAge(22);
        user.setEmail("123@163.com");
        user.setName("avroName");

        User user2= User.newBuilder().setAge(11).setEmail("123@126.com").setName("网易").build();

        //序列化
        String filePath = AvroTest.class.getClassLoader().getResource("").getPath();
        File file = new File(filePath, "user.avro");
        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user.getSchema(), new File(filePath, "user.avro"));
        dataFileWriter.append(user);
        dataFileWriter.append(user2);
        dataFileWriter.close();
        //反序列化
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(file, userDatumReader);
        User user1 = null;
        while (dataFileReader.hasNext()) {
            user1 = dataFileReader.next(user1);
            System.out.println(user1);
        }
    }
}
