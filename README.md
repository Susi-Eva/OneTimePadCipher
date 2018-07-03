# OneTimePadCipher
suruh dulu si evita mindahin yang diketiknya di DM ke sini wkwkwkwk biar bisa ku baca


Kami disuruh modif gini bang..
Misalnya ada 1000 char..
Dari 1000 char itu diambil perwakilan sebagai new plaintext dan new key bang..
Dimana perwakilan itu hanya 5 char.
Kmaren requirementnya:
New plaintext diambil dari 5 huruf dari awal yg nilai asciinya ganjil.
Sedangkan
New key diambil dari 5 huruf dari teks paling terakhir yang nilai asciinya genap bang.
Setiap ada char yg sama, maka char tsb di skip.
Dalam proses ini kami disuruh mencheck pake algoritma sorting bang..
Trus nanti chiper textnya dihasilkan dari Xor antara new plaintex dan new key bang.

Setelah itu baru di dekrip lagi bg, dan hasil dekripnya adalah si plaintext awal.
