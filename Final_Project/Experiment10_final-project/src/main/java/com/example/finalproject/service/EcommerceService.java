package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;

@Service
public class EcommerceService {

    private List<Product> products = new ArrayList<>();
    private Cart cart = new Cart();
    private List<Order> orders = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private AtomicLong orderIdCounter = new AtomicLong(1);
    private AtomicLong userIdCounter = new AtomicLong(1);

    public EcommerceService() {
        // Initialize with expanded product catalog (150+ products)
        initializeProducts();

        // Sample users with extended details
        users.add(new User(1L, "user", "user@example.com", "password", "USER", "John Doe", "+1-555-0123", "123 Main St", "New York", "10001", "USA"));
        users.add(new User(2L, "admin", "admin@example.com", "admin", "ADMIN", "Admin User", "+1-555-0124", "456 Admin Ave", "Los Angeles", "90210", "USA"));
    }

    private void initializeProducts() {
        // Electronics (50 products)
        addElectronicsProducts();
        // Fashion (40 products)
        addFashionProducts();
        // Home & Garden (30 products)
        addHomeProducts();
        // Sports & Outdoors (30 products)
        addSportsProducts();
    }

    private void addElectronicsProducts() {
        // Laptops & Computers
        products.add(new Product(1L, "MacBook Pro 16\"", 2499.99, "Apple M3 Pro chip, 18GB RAM, 512GB SSD, 16-inch Liquid Retina XDR display", "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(2L, "Dell XPS 13", 1299.99, "13.4-inch InfinityEdge display, Intel Core i7, 16GB RAM, 512GB SSD", "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(3L, "ASUS ROG Gaming Laptop", 1899.99, "RTX 4070, Intel i9, 32GB RAM, 1TB SSD, 15.6-inch 165Hz display", "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(4L, "Lenovo ThinkPad X1 Carbon", 1599.99, "12th Gen Intel, 16GB RAM, 512GB SSD, 14-inch display", "https://images.unsplash.com/photo-1588872657578-7efd1f1555ed?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(5L, "HP Spectre x360", 1399.99, "Intel i7, 16GB RAM, 512GB SSD, 2-in-1 convertible", "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=400&h=300&fit=crop", "electronics"));

        // Smartphones
        products.add(new Product(6L, "iPhone 15 Pro", 1199.99, "A17 Pro chip, Pro camera system, Titanium design, 128GB storage", "https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(7L, "Samsung Galaxy S24 Ultra", 1199.99, "200MP camera, S Pen, titanium frame, 512GB storage", "https://images.unsplash.com/photo-1610945415295-d9bbf067e59c?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(8L, "Google Pixel 8 Pro", 999.99, "Tensor G3 chip, 48MP camera, 7 years updates, 128GB storage", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(9L, "OnePlus 12", 899.99, "Snapdragon 8 Gen 3, 50MP camera, 100W charging, 256GB storage", "https://images.unsplash.com/photo-1565849904461-04a58ad377e0?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(10L, "Xiaomi 14 Ultra", 1099.99, "Leica cameras, Snapdragon 8 Gen 3, 120W charging", "https://images.unsplash.com/photo-1592899677977-9c10ca588bbd?w=400&h=300&fit=crop", "electronics"));

        // Tablets
        products.add(new Product(11L, "iPad Pro 12.9\"", 1099.99, "M2 chip, 12.9-inch Liquid Retina XDR display, Apple Pencil Pro support", "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(12L, "Samsung Galaxy Tab S9 Ultra", 1199.99, "14.6-inch AMOLED, Snapdragon 8 Gen 2, S Pen included", "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(13L, "Microsoft Surface Pro 9", 999.99, "Intel i5, 8GB RAM, 128GB SSD, detachable keyboard", "https://images.unsplash.com/photo-1587614295999-6c1f4c4b98ea?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(14L, "Amazon Fire HD 10", 149.99, "10.1-inch display, 32GB storage, Alexa built-in", "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(15L, "Lenovo Tab P12 Pro", 499.99, "12.6-inch OLED, Snapdragon 870, precision pen", "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=400&h=300&fit=crop", "electronics"));

        // Audio Devices
        products.add(new Product(16L, "Sony WH-1000XM5", 399.99, "Industry-leading noise canceling, 30-hour battery, premium comfort", "https://images.unsplash.com/photo-1583394838336-acd977736f90?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(17L, "AirPods Pro (2nd gen)", 249.99, "Active noise cancellation, spatial audio, MagSafe charging", "https://images.unsplash.com/photo-1606220945770-b5b6c2c4b686?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(18L, "Bose QuietComfort Ultra", 429.99, "World-class noise cancellation, 24-hour battery, spatial audio", "https://images.unsplash.com/photo-1484704849700-f032a568e944?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(19L, "JBL Live 500BT", 99.99, "Wireless over-ear headphones, 30-hour battery, Google Assistant", "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(20L, "Sony WF-1000XM4", 279.99, "True wireless, industry-leading ANC, 8-hour battery", "https://images.unsplash.com/photo-1590658268037-6bf12165a8df?w=400&h=300&fit=crop", "electronics"));

        // Wearables
        products.add(new Product(21L, "Apple Watch Ultra 2", 799.99, "Titanium case, precision dual-frequency GPS, 36-hour battery life", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(22L, "Samsung Galaxy Watch 6", 399.99, "Wear OS, health monitoring, 40mm titanium case", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(23L, "Garmin Fenix 7", 699.99, "Multi-sport GPS watch, advanced training metrics", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(24L, "Fitbit Charge 6", 149.99, "Advanced health metrics, GPS, 7-day battery", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(25L, "Whoop 4.0", 299.99, "Strain, recovery, sleep tracking, 5-day battery", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "electronics"));

        // Monitors & Displays
        products.add(new Product(26L, "Samsung Odyssey G9", 1499.99, "49-inch curved gaming monitor, 240Hz, 4K UHD, Quantum Dot", "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(27L, "LG UltraFine 5K", 1299.99, "27-inch 5K display, Thunderbolt 3, P3 color accuracy", "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(28L, "Dell UltraSharp U2720Q", 699.99, "27-inch 4K UHD, USB-C, 99% sRGB color gamut", "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(29L, "ASUS ROG Swift PG279QM", 899.99, "27-inch 1440p, 240Hz, G-Sync, 1ms response", "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(30L, "BenQ PD2700Q", 599.99, "27-inch 1440p, 100% sRGB, hardware calibration", "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?w=400&h=300&fit=crop", "electronics"));

        // Peripherals
        products.add(new Product(31L, "Logitech MX Keys", 129.99, "Advanced illuminated keyboard, multi-device Bluetooth, 10m range", "https://images.unsplash.com/photo-1587825140708-dfaf72ae4b04?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(32L, "Logitech MX Master 3S", 99.99, "Advanced wireless mouse, 8K DPI, 70-day battery, multi-device", "https://images.unsplash.com/photo-1527814050087-3793815479db?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(33L, "Razer DeathAdder V3", 99.99, "30K DPI optical sensor, 90-hour battery, esports grade", "https://images.unsplash.com/photo-1527814050087-3793815479db?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(34L, "Corsair K57 RGB", 79.99, "Wireless gaming keyboard, per-key RGB, 175-hour battery", "https://images.unsplash.com/photo-1587825140708-dfaf72ae4b04?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(35L, "SteelSeries Arctis 7", 149.99, "Wireless gaming headset, 24-hour battery, Discord certified", "https://images.unsplash.com/photo-1583394838336-acd977736f90?w=400&h=300&fit=crop", "electronics"));

        // Cameras
        products.add(new Product(36L, "Sony A7R V", 3899.99, "61MP full-frame sensor, 8K video, 5-axis stabilization", "https://images.unsplash.com/photo-1606983340126-99ab4feaa64a?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(37L, "Canon EOS R6 Mark II", 2499.99, "24MP full-frame, 4K 60p video, IBIS stabilization", "https://images.unsplash.com/photo-1606983340126-99ab4feaa64a?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(38L, "Nikon Zf", 1999.99, "24MP full-frame, retro design, 4K video, IBIS", "https://images.unsplash.com/photo-1606983340126-99ab4feaa64a?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(39L, "Fujifilm X-T5", 1699.99, "40MP APS-C sensor, 6.2K video, IBIS, retro design", "https://images.unsplash.com/photo-1606983340126-99ab4feaa64a?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(40L, "Panasonic Lumix S5 II", 1999.99, "24MP full-frame, 6K video, phase-detect AF, IBIS", "https://images.unsplash.com/photo-1606983340126-99ab4feaa64a?w=400&h=300&fit=crop", "electronics"));

        // Smart Home
        products.add(new Product(41L, "Amazon Echo Dot (5th Gen)", 49.99, "Smart speaker with Alexa, improved audio, temperature sensor", "https://images.unsplash.com/photo-1543512214-318c7553f230?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(42L, "Google Nest Hub Max", 229.99, "10-inch smart display, Google Assistant, 10MP camera", "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(43L, "Ring Video Doorbell Pro 2", 249.99, "1080p HD video, motion detection, two-way audio", "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(44L, "Philips Hue Starter Kit", 99.99, "Smart LED bulbs, bridge, voice control compatible", "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(45L, "Nest Learning Thermostat", 249.99, "Smart thermostat, energy saving, remote control", "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&h=300&fit=crop", "electronics"));

        // Gaming
        products.add(new Product(46L, "PlayStation 5", 499.99, "Next-gen gaming console, 825GB SSD, 4K gaming", "https://images.unsplash.com/photo-1606813907291-d86efa9b94db?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(47L, "Xbox Series X", 499.99, "4K gaming, 1TB SSD, Quick Resume technology", "https://images.unsplash.com/photo-1621259182978-fbf93132d53d?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(48L, "Nintendo Switch OLED", 349.99, "7-inch OLED screen, enhanced audio, 64GB storage", "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(49L, "Steam Deck OLED", 549.99, "7.4-inch OLED screen, AMD APU, 512GB storage", "https://images.unsplash.com/photo-1625842268584-8f3296236761?w=400&h=300&fit=crop", "electronics"));
        products.add(new Product(50L, "Razer Blade 16", 2699.99, "Intel i9, RTX 4080, 16-inch QHD+ 240Hz display", "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=400&h=300&fit=crop", "electronics"));
    }

    private void addFashionProducts() {
        // Clothing
        products.add(new Product(51L, "Levi's 501 Original Jeans", 89.99, "Classic straight fit jeans, 100% cotton, vintage inspired", "https://images.unsplash.com/photo-1542272604-787c3835535d?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(52L, "Nike Air Max 270", 150.99, "Running shoes with Air Max cushioning, breathable mesh", "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(53L, "Adidas Ultraboost 23", 190.99, "Running shoes with Boost technology, Primeknit upper", "https://images.unsplash.com/photo-1549298916-b41d501d3772?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(54L, "Supreme Box Logo Hoodie", 299.99, "Cotton fleece hoodie, box logo print, premium quality", "https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(55L, "Gucci Marmont Matelassé Bag", 2290.99, "GG Supreme canvas, matelassé leather, gold-tone hardware", "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400&h=300&fit=crop", "fashion"));

        // Accessories
        products.add(new Product(56L, "Rolex Submariner", 8999.99, "Automatic chronometer, ceramic bezel, 40mm case", "https://images.unsplash.com/photo-1524592094714-0f0654e20314?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(57L, "Ray-Ban Aviator Sunglasses", 179.99, "Classic aviator style, polarized lenses, gold frame", "https://images.unsplash.com/photo-1572635196237-14b3f281503f?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(58L, "Louis Vuitton Monogram Belt", 890.99, "Monogram canvas, gold-tone buckle, adjustable fit", "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(59L, "Hermès Silk Scarf", 499.99, "100% silk, hand-rolled edges, iconic patterns", "https://images.unsplash.com/photo-1601924582970-9238bcb495d9?w=400&h=300&fit=crop", "fashion"));
        products.add(new Product(60L, "Cartier Love Bracelet", 6999.99, "18k yellow gold, screw head closure, iconic design", "https://images.unsplash.com/photo-1515562141207-7a88fb7ce338?w=400&h=300&fit=crop", "fashion"));

        // Add more fashion products to reach 40...
        for (int i = 61; i <= 90; i++) {
            products.add(new Product((long) i, "Fashion Item " + i, 49.99 + (i * 10), "Premium fashion item with modern design", "https://images.unsplash.com/photo-1445205170230-053b83016050?w=400&h=300&fit=crop", "fashion"));
        }
    }

    private void addHomeProducts() {
        // Furniture
        products.add(new Product(91L, "IKEA KIVIK Sofa", 899.99, "3-seater sofa, durable fabric, comfortable seating", "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=400&h=300&fit=crop", "home"));
        products.add(new Product(92L, "West Elm Mid-Century Chair", 599.99, "Eames-inspired design, walnut wood, premium leather", "https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=400&h=300&fit=crop", "home"));
        products.add(new Product(93L, "CB2 Platform Bed", 1299.99, "King size platform bed, solid wood frame, storage drawers", "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?w=400&h=300&fit=crop", "home"));
        products.add(new Product(94L, "Pottery Barn Dining Table", 1499.99, "Extendable dining table, seats 6-8, reclaimed wood", "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=400&h=300&fit=crop", "home"));
        products.add(new Product(95L, "Crate & Barrel Bookshelf", 399.99, "5-tier bookshelf, engineered wood, modern design", "https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=400&h=300&fit=crop", "home"));

        // Kitchen
        products.add(new Product(96L, "KitchenAid Stand Mixer", 379.99, "5-quart tilt-head mixer, 10 speeds, multiple attachments", "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400&h=300&fit=crop", "home"));
        products.add(new Product(97L, "Breville Espresso Machine", 699.99, "Automatic espresso machine, integrated grinder, milk frother", "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=400&h=300&fit=crop", "home"));
        products.add(new Product(98L, "Instant Pot Duo", 89.99, "7-in-1 electric pressure cooker, 6-quart capacity", "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400&h=300&fit=crop", "home"));
        products.add(new Product(99L, "Vitamix Blender", 349.99, "Professional-grade blender, 64 oz container, variable speed", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "home"));
        products.add(new Product(100L, "Le Creuset Dutch Oven", 299.99, "7-quart enameled cast iron, flame red, oven safe", "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=400&h=300&fit=crop", "home"));

        // Add more home products to reach 30...
        for (int i = 101; i <= 120; i++) {
            products.add(new Product((long) i, "Home Item " + i, 29.99 + (i * 5), "Quality home and garden product", "https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=400&h=300&fit=crop", "home"));
        }
    }

    private void addSportsProducts() {
        // Fitness Equipment
        products.add(new Product(121L, "Peloton Bike", 2495.99, "Interactive fitness bike, HD touchscreen, live classes", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(122L, "Bowflex SelectTech Dumbbells", 399.99, "Adjustable dumbbells, 5-52.5 lbs each, space-saving design", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(123L, "NordicTrack Treadmill", 1299.99, "Folding treadmill, iFit compatibility, 10\" touchscreen", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(124L, "Yoga Mat", 39.99, "Non-slip yoga mat, 6mm thick, eco-friendly material", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(125L, "Resistance Bands Set", 29.99, "5-piece resistance band set, door anchor included", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "sports"));

        // Outdoor Gear
        products.add(new Product(126L, "Coleman Camping Tent", 149.99, "4-person dome tent, weatherproof, easy setup", "https://images.unsplash.com/photo-1504851149312-7a075b496cc7?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(127L, "Patagonia Hiking Backpack", 129.99, "45L hiking backpack, recycled materials, hydration compatible", "https://images.unsplash.com/photo-1622260613188-1d82ad8e05c4?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(128L, "Garmin GPS Watch", 299.99, "GPS multisport watch, heart rate monitor, training status", "https://images.unsplash.com/photo-1434494878577-86c23bcb06b9?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(129L, "Hydro Flask Water Bottle", 39.99, "18 oz insulated stainless steel water bottle, BPA-free", "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=400&h=300&fit=crop", "sports"));
        products.add(new Product(130L, "Osprey Daypack", 89.99, "26L day hiking backpack, ventilated back panel", "https://images.unsplash.com/photo-1622260613188-1d82ad8e05c4?w=400&h=300&fit=crop", "sports"));

        // Add more sports products to reach 30...
        for (int i = 131; i <= 150; i++) {
            products.add(new Product((long) i, "Sports Item " + i, 19.99 + (i * 3), "Premium sports and outdoor equipment", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=400&h=300&fit=crop", "sports"));
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Long productId) {
        Product product = getProductById(productId);
        if (product != null) {
            cart.addProduct(product);
        }
    }

    public void removeFromCart(Long productId) {
        Product product = getProductById(productId);
        if (product != null) {
            cart.removeProduct(product);
        }
    }

    public void updateCartQuantity(Long productId, int quantity) {
        Product product = getProductById(productId);
        if (product != null) {
            cart.updateQuantity(product, quantity);
        }
    }

    public void removeAllFromCart(Long productId) {
        Product product = getProductById(productId);
        if (product != null) {
            cart.removeAll(product);
        }
    }

    public Order placeOrder(String customerName) {
        if (cart.getItemQuantities().isEmpty()) {
            return null;
        }
        Order order = new Order(orderIdCounter.getAndIncrement(), cart.getItemQuantities(), cart.getTotal(), customerName, java.time.LocalDateTime.now());
        orders.add(order);
        cart.clear();
        return order;
    }

    public void clearCart() {
        cart.clear();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public User registerUser(String username, String email, String password) {
        User user = new User(userIdCounter.getAndIncrement(), username, email, password, "USER", null, null, null, null, null, null);
        users.add(user);
        return user;
    }

    public User findUserByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public List<Product> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return products;
        }
        String lowerQuery = query.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(lowerQuery) ||
                           p.getDescription().toLowerCase().contains(lowerQuery) ||
                           p.getCategory().toLowerCase().contains(lowerQuery))
                .toList();
    }

    public List<Product> filterProducts(String category, Double minPrice, Double maxPrice) {
        return products.stream()
                .filter(p -> category == null || category.isEmpty() || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .toList();
    }

    public List<Product> searchAndFilterProducts(String query, String category, Double minPrice, Double maxPrice) {
        return products.stream()
                .filter(p -> query == null || query.trim().isEmpty() ||
                           p.getName().toLowerCase().contains(query.toLowerCase()) ||
                           p.getDescription().toLowerCase().contains(query.toLowerCase()) ||
                           p.getCategory().toLowerCase().contains(query.toLowerCase()))
                .filter(p -> category == null || category.isEmpty() || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .toList();
    }
}
