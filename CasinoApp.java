import java.util.ArrayList;
import java.util.List;

public class CasinoApp {

    static class User {
        private int id;
        private String name;
        private String login;
        private String password;
        private String createdDate;
        private float balance;

        public User(int id, String name, String login, String password, String createdDate, float balance) {
            this.id = id;
            this.name = name;
            this.login = login;
            this.password = password;
            this.createdDate = createdDate;
            this.balance = balance;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public float getBalance() { return balance; }
    }

    static class Slot {
        private int id;
        private String name;
        private int maxBet;
        private int minBet;
        private float payoutRatio;

        public Slot(int id, String name, int maxBet, int minBet, float payoutRatio) {
            this.id = id;
            this.name = name;
            this.maxBet = maxBet;
            this.minBet = minBet;
            this.payoutRatio = payoutRatio;
        }

        public String getName() { return name; }
        public float getPayoutRatio() { return payoutRatio; }
    }

    static class Transaction {
        private int id;
        private int userId;
        private float amount;
        private String timestamp;

        public Transaction(int id, int userId, float amount, String timestamp) {
            this.id = id;
            this.userId = userId;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public float getAmount() { return amount; }
        public int getUserId() { return userId; }
    }

    static class GameHistory {
        private Slot slot;
        private User user;
        private int id;
        private float betAmount;
        private float winAmount;
        private String playDate;

        public GameHistory(Slot slot, User user, int id, float betAmount, float winAmount, String playDate) {
            this.slot = slot;
            this.user = user;
            this.id = id;
            this.betAmount = betAmount;
            this.winAmount = winAmount;
            this.playDate = playDate;
        }

        public void displayHistory() {
            System.out.printf("История игры:\nИгрок: %s, Слот: %s, Ставка: %.2f, Выигрыш: %.2f, Дата игры: %s\n",
                    user.getName(), slot.getName(), betAmount, winAmount, playDate);
        }
    }

    static class Casino {
        private List<User> users = new ArrayList<>();
        private List<Slot> slots = new ArrayList<>();
        private List<GameHistory> gameHistories = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public void addSlot(Slot slot) {
            slots.add(slot);
        }

        public void addGameHistory(GameHistory history) {
            gameHistories.add(history);
        }

        public void displayGameHistories() {
            for (GameHistory history : gameHistories) {
                history.displayHistory();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Работа с классом User:");
        User user = new User(1, "Алексей", "alex123", "alexpass", "2024-10-13", 1500.0f);
        System.out.printf("ID: %d, Имя: %s, Баланс: %.2f\n", user.getId(), user.getName(), user.getBalance());

        System.out.println("\nРабота с классом Slot:");
        Slot slot = new Slot(1, "Lucky 7", 100, 10, 0.95f);
        System.out.printf("Название: %s, Коэффициент выплат: %.2f\n", slot.getName(), slot.getPayoutRatio());

        System.out.println("\nРабота с классом Transaction:");
        Transaction transaction = new Transaction(1, 1, 100.0f, "2024-10-13 12:00");
        System.out.printf("ID пользователя: %d, Сумма: %.2f, Время: %s\n",
                transaction.getUserId(), transaction.getAmount(), "2024-10-13 12:00");

        System.out.println("\nРабота с классом GameHistory:");
        User player = new User(2, "Борис", "boris123", "borispass", "2024-10-13", 2500.0f);
        Slot game = new Slot(2, "Fruit Machine", 50, 5, 1.2f);
        GameHistory history = new GameHistory(game, player, 1, 50.0f, 60.0f, "2024-10-13");
        history.displayHistory();

        Casino casino = new Casino();
        casino.addUser(user);
        casino.addSlot(slot);
        casino.addGameHistory(history);

        System.out.println("\nИстория игр в казино:");
        casino.displayGameHistories();
    }
}
