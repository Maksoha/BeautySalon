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
import ru.example.beautysalon.data.data_sources.room.dao.ServiceDao;
import ru.example.beautysalon.data.data_sources.room.dao.TypeServiceDao;
import ru.example.beautysalon.data.data_sources.room.dao.CardSpecialistDao;
import ru.example.beautysalon.data.data_sources.room.entities.CardSaleEntity;
import ru.example.beautysalon.data.data_sources.room.entities.ServiceEntity;
import ru.example.beautysalon.data.data_sources.room.entities.TypeServiceEntity;
import ru.example.beautysalon.data.data_sources.room.entities.CardSpecialistEntity;

@Database(entities = {CardSaleEntity.class, TypeServiceEntity.class, CardSpecialistEntity.class, ServiceEntity.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CardSaleDao cardSaleDao();
    public abstract TypeServiceDao typeServiceDao();

    public abstract ServiceDao serviceDao();
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
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Все"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Брови/Ресницы"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Косметология"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Парикмахер"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Визаж"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Маникюр/Педикюр"));
                INSTANCE.typeServiceDao().addNewItem(new TypeServiceEntity("Депиляция"));
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

            Executors.newSingleThreadExecutor().execute(() -> {
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Брови/Ресницы", "Оформление бровей", 500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Брови/Ресницы", "Вельвет бровей", 2500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Брови/Ресницы", "Вельвет ресниц", 2500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Брови/Ресницы", "Ламинирование бровей", 1500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Брови/Ресницы", "Ламинирование ресниц", 1500));

                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Массаж лица классический", 1000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Массаж лица лимфодренажный", 1500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Массаж лица букальный", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Криомассаж лица", 1500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Маска для лица", 500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Косметология", "Альгинатная маска", 500));

                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Парикмахер", "Стрижка женская", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Парикмахер", "Подравнивание", 500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Парикмахер", "Стрижка горячим лезвием", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Парикмахер", "Окрашивание в 1 тон", 3000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Парикмахер", "Сложное окрашивание", 5000));

                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Визаж", "\"Экспресс\" макияж", 1000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Визаж", "Сложный макияж", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Визаж", "Микроблейдинг бровей", 4500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Визаж", "Перманентный макияж стрелка", 1000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Визаж", "Стрижка челки", 5000));

                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Аппаратный маникюр", 500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Маникюр Японский", 1000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Маникюр+педикюр в 4 руки", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Аппаратный педикюр", 1200));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Снятие нарощенных ногтей", 500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Наращивание ногтей", 2500));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Френч", 300));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Маникюр/Педикюр", "Градиент", 700));

                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Депиляция", "Депиляция всего тела", 2000));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Депиляция", "Подмышечные впадины", 300));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Депиляция", "Бикини трусики", 400));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Депиляция", "Бикини глубокое", 800));
                INSTANCE.serviceDao().addNewItem(new ServiceEntity("Депиляция", "Ноги до колен", 5000));
            });
        }
    };
}
