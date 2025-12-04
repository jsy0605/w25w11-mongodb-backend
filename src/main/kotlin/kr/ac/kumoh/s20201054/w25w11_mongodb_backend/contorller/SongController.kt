package kr.ac.kumoh.s20201054.w25w11_mongodb_backend.contorller

import kr.ac.kumoh.s20201054.w25w11_mongodb_backend.model.Song
import kr.ac.kumoh.s20201054.w25w11_mongodb_backend.service.SongService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = ["http://localhost:5173"])
class SongController(
    private val service: SongService
) {
    // Create
    @PostMapping
    fun addSong(@RequestBody song: Song): Song = service.addSong(song)

    // Read (Retrieve)
    @GetMapping
    fun getAllSongs(): List<Song> = service.getAllSongs()

    @GetMapping("/{id}")
    fun getSongById(@PathVariable id: String): Song? = service.getSongById(id)

    @GetMapping("/singer/{singer}")
    fun getSongBySinger(@PathVariable singer: String): List<Song> = service.getSongBySinger(singer)

    // Update
    @PutMapping("/{id}")
    fun updateSong(
        @PathVariable id: String,
        @RequestBody songDetails: Song
    ): Song? =  service.updateSong(id, songDetails)

    // Delete
    @DeleteMapping("/{id}")
    fun deleteSong(@PathVariable id: String): Map<String, String> {
        return if (service.deleteSong(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}