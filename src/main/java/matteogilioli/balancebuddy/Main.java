package matteogilioli.balancebuddy;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import matteogilioli.balancebuddy.model.Balance;
import matteogilioli.balancebuddy.model.ExpenseEntry;
import matteogilioli.balancebuddy.model.IncomeEntry;
import matteogilioli.balancebuddy.view.BudgetBuddyFrame;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public final class Main {
    public static void main(String[] args) {
        FlatMacLightLaf.setup();

        populate(); // Examples

        SwingUtilities.invokeLater(() -> {
            BudgetBuddyFrame f = new BudgetBuddyFrame();
        });
    }

    public static void populate() {
        Balance.addEntry(new ExpenseEntry("Netflix", new BigDecimal(14.99), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Spesa", new BigDecimal(50), randomDateTime()));
        Balance.addEntry(new IncomeEntry("Stipendio", new BigDecimal(800), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Mancia", new BigDecimal(50), randomDateTime()));
        Balance.addEntry(new ExpenseEntry("Ristorante Oriente", new BigDecimal(14.99), randomDateTime()));
        Balance.addEntry(new IncomeEntry("Benzina", new BigDecimal(60), randomDateTime()));
    }

    public static LocalDateTime randomDateTime() {
        LocalDateTime from = LocalDateTime.of(2022, 6, 1, 0, 0);
        LocalDateTime to = LocalDateTime.now();
        long startSeconds = from.toEpochSecond(ZoneOffset.UTC);
        long endSeconds = to.toEpochSecond(ZoneOffset.UTC);
        long randomSeconds = startSeconds + new Random().nextInt((int)(endSeconds - startSeconds));
        return LocalDateTime.ofEpochSecond(randomSeconds, 0, ZoneOffset.UTC);
    }
}