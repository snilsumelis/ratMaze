# Maze Solver with Stack

## Main Class

- **InputMaze()**: Bu metot, kullanıcıdan labirentin boyutlarını ve içeriğini alır.
- **FindPath()**: Labirentte bir yol arar. Bir yol bulunduğunda `true` döndürür, aksi halde `false` döndürür.
- **OutputPath()**: Bulunan yolu konsola yazdırır.
- **main()**: Programın giriş noktasıdır. Labirenti alır, bir yol bulmaya çalışır ve sonucu konsola yazdırır.

## Position Class

- Labirent içindeki konumu temsil eder.
- `row` ve `col` olmak üzere iki özellik içerir.

### Notlar

- Labirent matrisi, boş yolları 0'lar ve engelleri 1'lerle temsil eder.
- Bir yol ararken sağa, sola, yukarı ve aşağı hareket edilir.
- Bulunan yol, bir yığın veri yapısında saklanır ve çıkışa ulaşılana kadar devam eder.

