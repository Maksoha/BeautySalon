package ru.example.beautysalon.data.data_sources.room.root;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.example.beautysalon.data.data_sources.room.dao.CardSaleDao;
import ru.example.beautysalon.data.data_sources.room.dao.TypeServiceDao;
import ru.example.beautysalon.data.data_sources.room.dao.CardSpecialistDao;
import ru.example.beautysalon.data.data_sources.room.entities.CardSaleEntity;
import ru.example.beautysalon.data.data_sources.room.entities.TypeServiceEntity;
import ru.example.beautysalon.data.data_sources.room.entities.CardSpecialistEntity;

@Database(entities = {CardSaleEntity.class, TypeServiceEntity.class, CardSpecialistEntity.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CardSaleDao cardSaleDao();
    public abstract TypeServiceDao serviceDao();

    public abstract CardSpecialistDao cardSpecialistDao();
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static volatile AppDataBase INSTANCE;


    public static AppDataBase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            Executors.newSingleThreadExecutor().execute(() -> {
                for (int i = 0; i < 5; i++) {
                    INSTANCE.cardSaleDao().addNewItem(new CardSaleEntity("Акция"));
                }
            });

            Executors.newSingleThreadExecutor().execute(() -> {
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Все"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Брови/Ресницы"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Косметология"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Парикмахер"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Визаж"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Маникюр/Педикюр"));
                INSTANCE.serviceDao().addNewItem(new TypeServiceEntity("Депиляция"));
            });

            Executors.newSingleThreadExecutor().execute(() -> {
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Лашмейкер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Лашмейкер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Лашмейкер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Лашмейкер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Лашмейкер"));

                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Косметолог"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Косметолог"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Косметолог"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Косметолог"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Косметолог"));

                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Парикмахер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Парикмахер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Парикмахер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Парикмахер"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Парикмахер"));

                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Визажист"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Визажист"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Визажист"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Визажист"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Визажист"));

                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Мастер ногтевого сервиса"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Мастер ногтевого сервиса"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Мастер ногтевого сервиса"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Мастер ногтевого сервиса"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Мастер ногтевого сервиса"));

                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анастасия", "Мастер депиляции"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Анна", "Мастер депиляции"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Виктория", "Мастер депиляции"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Елена", "Мастер депиляции"));
                INSTANCE.cardSpecialistDao().addNewItem(new CardSpecialistEntity("Юлия", "Мастер депиляции"));

            });
        }
    };
}
