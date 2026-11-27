# Bank-Software - Testfälle

## Black-Box

| ID | Testfall | Eingabe | Erwartet |
|-|-|-|-|
| 1 | Konto wählen | `1` | Kontodetails werden angezeigt |
| 2 | Unbekanntes Konto | `99` | Meldung «Konto nicht vorhanden» |
| 3 | Alle Konten anzeigen | `a` | Liste aller Konten |
| 4 | Konto erstellen | `e`, Name, `CHF` | Neues Konto mit Saldo 0 |
| 5 | Einzahlen | `e`, `500` | Saldo steigt um 500 |
| 6 | Abheben | `a`, `500` | Saldo sinkt um 500 |
| 7 | Zu viel abheben | `a`, Betrag > Saldo | Meldung «Kontostand zu niedrig» |
| 8 | Negativer Betrag | `e` / `a`, `-500` | Fehlermeldung (Fehlgeschlagen wird akzeptiert) |
| 9 | Überweisen | `ü`, Konto, Betrag | Geld wird übertragen |
| 10 | Überweisen EUR → CHF | `ü`, `3`, `100` | Betrag umgerechnet (Fehlgeschlagen keine Umrechnung) |
| 11 | Konto löschen | `l`, `j` | Konto wird gelöscht |
| 12 | Leere Eingabe im Kontomenü | Enter | Fehlermeldung (Fehlgeschlagen: Absturz) |
| 13 | Wechselkurs abfragen | `w`, `CHF USD` | Aktueller Kurs wird angezeigt |
| 14 | Beenden | `q` | Programm endet |

## White-Box

| Klasse | Methode | Was testen |
|-|-|-|
| `Account` | `deposit()` | Saldo steigt, negative Beträge |
| `Account` | `withdraw()` | `true`/`false`, Grenzwert = Saldo |
| `Bank` | `createAccount()` | Konto in Liste, Anzahl +1 |
| `Bank` | `getAccount()` | Konto gefunden / `null` |
| `Bank` | `deleteAccount()` | Konto aus Liste entfernt |
| `Counter` | `convertCurrency()` | Alle Währungspaare |
| `Counter` | `transferAmount()` | Saldo beider Konten |
| `ExchangeRateOkhttp` | `getExchangeRate()` | Erfolg / Fehler → `0.0` |

## Verbesserungen

| Problem | Verbesserung |
|---------|--------------|
| Negative Beträge erlaubt | Betrag > 0 prüfen |
| Absturz bei leerer Eingabe | Eingabe auf leer prüfen |
| Umrechnung unvollständig | Alle Währungspaare / API nutzen |
| `double` für Geld | `BigDecimal` verwenden |
| API-Key im Code | In Config / Umgebungsvariable |
| UI und Logik vermischt | Trennen → besser testbar |
| `catch (Exception e)` | Spezifische Exceptions fangen |
| Tippfehler `AccountExeption` | Saubere Namen |
| Keine Tests | JUnit-Tests ergänzen |